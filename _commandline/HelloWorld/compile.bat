@echo off
call set.bat
echo JAVA BIN: %JAVA_BIN%
%JAVA_BIN%\javac -d ./bin src/hu/qwaevisz/demo/HelloWorld.java 
echo compile complete