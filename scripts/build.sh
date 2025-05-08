# #!/bin/bash
# mkdir -p build
# javac -d build src/*.java
# echo "✅ Java code compiled."
#!/bin/bash

echo "🔧 Starting Java build..."

# Set up directories
SRC_DIR="src"
BUILD_DIR="build"
JAR_NAME="app.jar"

# Create build directory if it doesn't exist
mkdir -p "$BUILD_DIR"

# Compile Java files
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java

# Check if compilation succeeded
if [ $? -eq 0 ]; then
    echo "✅ Compilation successful."

    # Package into a .jar file
    cd "$BUILD_DIR" || exit
    jar cfe "$JAR_NAME" Main *.class
    mv "$JAR_NAME" ../
    cd ..

    echo "📦 JAR file created: $JAR_NAME"
else
    echo "❌ Compilation failed."
    exit 1
fi
