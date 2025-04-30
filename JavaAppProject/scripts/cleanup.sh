#!/bin/bash
find output/ -name "*.zip" -type f -mtime +2 -exec rm -f {} \;
echo "✅ Old zip files deleted."
