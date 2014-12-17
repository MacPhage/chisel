#!/bin/sh
iconfile="Icon1024.png"
iconsetname="nw.iconset"
here="`dirname \"$0\"`"
echo "cd-ing to $here"
cd "$here" || exit 1
cd ..

cd ./source/icons/
cp $iconfile ../app.nw/icon/$iconfile

echo "Creating ICONSET..."
mkdir $iconsetname
sips -z 16 16     $iconfile --out nw.iconset/icon_16x16.png
sips -z 32 32     $iconfile --out nw.iconset/icon_16x16@2x.png
sips -z 32 32     $iconfile --out nw.iconset/icon_32x32.png
sips -z 64 64     $iconfile --out nw.iconset/icon_32x32@2x.png
sips -z 128 128   $iconfile --out nw.iconset/icon_128x128.png
sips -z 256 256   $iconfile --out nw.iconset/icon_128x128@2x.png
sips -z 256 256   $iconfile --out nw.iconset/icon_256x256.png
sips -z 512 512   $iconfile --out nw.iconset/icon_256x256@2x.png
sips -z 512 512   $iconfile --out nw.iconset/icon_512x512.png
cp $iconfile $iconsetname/icon_512x512@2x.png
echo "Done."

echo "Creating ICNS from iconset..."
iconutil -c icns $iconsetname
echo "Done."
#rm -R $iconsetname
