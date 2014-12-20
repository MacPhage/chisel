#!/bin/sh

#This shell script builds and creates a runnable OS X app based on the contents
#Of the ./source/app.nw/ and ./source/icons/ folders.

#The name of the folder in the ./bin/
nodewebkitversion="node-webkit-v0.11.2-osx-x64"
here="`dirname \"$0\"`"
echo "cd-ing to $here"
cd "$here" || exit 1
cd ..

./shell/build-app.command
cd build
echo "Copying build to Mac app..."
cp app.nw ../bin/dist/$nodewebkitversion/node-webkit.app/Contents/Resources/
echo "Done."

../shell/create-osx-icons.command
echo "Mounting icon..."
cd ../source/icons/
cp nw.icns ../../bin/dist/$nodewebkitversion/node-webkit.app/Contents/Resources/
echo "Done."

echo "Mounting Info.plist..."
cd ..
cp Info.plist ../bin/dist/$nodewebkitversion/node-webkit.app/Contents/
echo "Done."

echo "Setting icon..."
cd ..
# `setfileicon` is an OS X application for setting the icon of files and folders
# It is not built-in and can be found here:
# https://github.com/MacPhage/binaries/tree/master/bin/OSX/setfileicon
setfileicon "bin/dist/$nodewebkitversion/node-webkit.app/Contents/Resources/nw.icns" "bin/dist/$nodewebkitversion/node-webkit.app"
echo "Done."
