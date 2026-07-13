# Overview

As a software engineer, I wanted to learn a language outside the ones I already knew, so I chose Kotlin. I picked Kotlin because it is used heavily in Android development and is built on top of Java, so learning it also helps me understand JVM based languages better.

The software I wrote is a console based task tracker with a small game layer built on top of it. A user can add tasks, give each task a difficulty level of easy, medium, or hard, and then mark tasks as complete. Completing a task earns experience points based on its difficulty, and once enough experience points are earned the user levels up. The goal was to make a simple to do list feel more rewarding to use.

My purpose in writing this software was to practice the core building blocks of Kotlin, including mutable and immutable variables, expressions, conditionals, loops, functions, classes, and data classes, while building something that was more than just a throwaway example.

[Software Demo Video](https://youtu.be/-dsYGQdeQGI)

# Development Environment

I used IntelliJ IDEA as my IDE, along with the built in terminal for git commands. I used Git and GitHub for version control.

I wrote the software in Kotlin, targeting the JVM. I did not use any external libraries outside of the Kotlin standard library.

# Useful Websites

- [Kotlin Documentation](https://kotlinlang.org/)
- [Kotlin Wikipedia Page](https://en.wikipedia.org/wiki/Kotlin_(programming_language))
- [Comparison to Java](https://kotlinlang.org/docs/reference/comparison-to-java.html)

# Future Work

- Add a way to save tasks to a file so progress is not lost when the program closes
- Add the ability to edit or delete a task after it has been added
- Add a streak feature to reward completing tasks multiple days in a row
- Add input validation so the difficulty prompt does not accept invalid text silently