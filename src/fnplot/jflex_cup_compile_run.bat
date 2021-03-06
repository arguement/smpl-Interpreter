title Runs lexer, cup,then compiles and runs java files

jflex -d syntax syntax\FnPlotLexer && cup -destdir syntax -parser FnPlotParser syntax\FnPlotParser.cup && pause && javac -d bin gui\*.java semantics\*java syntax\*.java sys\*java values\*.java syntax\inbuiltfunctions\*.java -cp ".;syntax\java-cup-11b-runtime.jar;gui\cs34q-utils.jar" && java -cp "bin;gui\cs34q-utils.jar;syntax\java-cup-11b-runtime.jar" fnplot.gui.FnPlotFrame

jflex -d syntax syntax/FnPlotLexer
cup -destdir syntax -parser FnPlotParser syntax/FnPlotParser.cup 
javac -d bin gui/*.java semantics/*java syntax/*.java sys/*java values/*.java syntax/inbuiltfunctions/*.java -cp ".:syntax/java-cup-11b-runtime.jar:gui/cs34q-utils.jar"
 java -cp "bin:gui/cs34q-utils.jar:syntax/java-cup-11b-runtime.jar" fnplot.gui.FnPlotFrame