package com.cosmos.service

class PostalCodeTransformer {

    static void main(def args) {
        // First argument is the path to the input file, second argument is path to output (if specified)
        String pathToInput = args[0]
        String pathToOutput = "zipLatLong.txt"

        if (args.length > 1) {
            pathToOutput = args[1]
        }

        File inputFile = new File(pathToInput)
        List<String> zipLatLong = []

        inputFile.eachLine { line, number ->
            // Skip the header line
            if (number == 1) {
                return
            }

            String[] values = line.trim().split()
            assert values.length == 7

            // Join zip, latitude, and longitude into a CSV
            zipLatLong << [values[0], values[5], values[6]].join(",")
        }

        File outputFile = new File(pathToOutput)
        outputFile.withWriter { out ->
            zipLatLong.each { out.println it }
        }
    }
}
