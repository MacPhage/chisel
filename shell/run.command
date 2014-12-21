#!/bin/sh

#This shell script builds and creates a runnable OS X app based on the contents
#Of the ./source/app.nw/ and ./source/icons/ folders.

#The name of the folder in the ./bin/
nodewebkitversion="node-webkit-v0.11.2-osx-x64"
nodewebkitpath="./bin/$nodewebkitversion/node-webkit.app/Contents/MacOS/"
apppath="./build/app.nw"
here="`dirname \"$0\"`"
echo "cd-ing to $here"
cd "$here" || exit 1
cd ..

echo "[Shell] Starting node-webkit ($nodewebkitversion)..."
echo "[Shell] node-webkit path: $nodewebkitpath"
echo "[Shell] app.nw path: $apppath"

$nodewebkitpath/node-webkit $apppath
