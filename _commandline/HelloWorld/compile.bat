@echo off
call set.bat
echo JAVA BIN: %JAVA_BIN%
%JAVA_BIN%\javac hu/qwaevisz/demo/HelloWorld.java
echo compile complete