#!/bin/bash
zip -r build_output.zip build logs reports
mv build_output.zip output/
echo "✅ Build zipped."
