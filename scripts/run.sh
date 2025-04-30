#!/bin/bash
mkdir -p logs
nohup java -jar build/app.jar > logs/output.log 2>&1 &
echo "✅ Application started in background."
