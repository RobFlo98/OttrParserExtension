import sys
import traceback

from antlr4 import FileStream, CommonTokenStream, ParseTreeWalker, RecognitionException

from includes.ottrToSmwPython.OTTRParser import OTTRParser
from includes.ottrToSmwPython.OTTRToSMWConverter import OTTRToSMWConverter
from includes.ottrToSmwPython.NoGenerationErrorStrategy import NoGenerationErrorStrategy
from includes.ottrToSmwPython.stOTTR.stOTTRLexer import stOTTRLexer


class MyTokenStream(CommonTokenStream):

    def __init__(self):
        super()


def mediawiki_add_whitespace_in_front(string):
    lines = string.split('\n')
    new_string = '\n '.join(lines)
    return f" {new_string}"

def mediawiki_highlight(text,word):
    start = text.find(word)
    return text[0:start]+'\'\'\''+ word+ '\'\'\''+ text[start+len("testdate"):]


def debug_str(exception):

    token = exception.offendingToken
    tokenstream= token.getInputStream().strdata
    highlighted_tokenstream = mediawiki_highlight(tokenstream,token.text)


    line = token.line
    col = token.column
    s = mediawiki_add_whitespace_in_front(highlighted_tokenstream)
    print("{{ottr:ErrorMsg|The parser tripped up at %s:%s here (see bold text): |code=-3}}" % (line, col))
    print(s)


def main(argv):
    # print(argv)
    try:
        if len(argv) < 2:
            print("<--No second argument for file name that contains ottr data-->")
        else:
            input_stream = FileStream(argv[1], encoding='utf-8')
            lexer = stOTTRLexer(input_stream)
            stream = CommonTokenStream(lexer)

            parser = OTTRParser(stream)
            parser._errHandler = NoGenerationErrorStrategy()
            tree = parser.stOTTRDoc()

            printer = OTTRToSMWConverter(stream)
            walker = ParseTreeWalker()
            walker.walk(printer, tree)

    except KeyError as e:
        print("{{ottr:ErrorMsg|The string '''%s''' is not one of the defined arguments in the signature|code=-3}" %
              e.args[0])
    except RecognitionException as e:
        #print("{{ottr:ErrorMsg|Parser Error, see above|code=0}}")
        #print("<pre>"+str(e.offendingToken)+"</pre>")
        debug_str(e)
        pass

    except Exception as e:
        traceback.print_exc()
        pass


def run():

    main(sys.argv)


if __name__ == '__main__':

    run()
