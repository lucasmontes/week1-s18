# CSCI 1102 Computer Science 2

### Spring 2018

------

## Lecture Notes

### Week 1: Getting Started

#### Topics:

1. What is CSCI 1102 about?
2. Introduction to Java

---

**Notes:**

      1. Course [home page](https://github.com/BC-CSCI1102/s18)

      2. Syllabus under the Resources link, we expect you to read the syllabus and follow the protocols laid out there.

      3. We're otherwise have a laptop-free classroom, please close your laptop when class starts.
---

## 1. What is CS102 about?

  + Generally speaking, CS is concerned with:
    + information — data
    + computation — algorithm

  + CSCI 1102 studies:
    + data:
      + how to *represent* data so that we can manipulate it in a good way
        + spoiler: 
          + we'll usually structure it in some way;
          + structure often determined by *ordering* the data

    + algorithm: what is a "good" algorithm?
      + correct (!)
      + efficient — time & space
      + maintainable

  + Devising ways to structure data and their related algorithms can be seen as *developing new* *types*.
    + a central activity of coding, and the focus of this course

  + new types should be *modular* and *compositional*

    + modular:
      + types are packaged up — think lego blocks; 
      + build new types out of old types by plugging them together

    + compositional:
      + what things are plug-compatible
      + *types mediate the composition*.

  + Methodology: Abstract Data Types (ADTs)
    + Barbara Liskov (~1974, 2009 Turing Award winner)
      1. introduce a named type
      2. introduce named operations (functions) acting on the type
      3. separate:
         + specification (or signature)
         + implementation
      4. client/user knows only the specification, the implementation is opaque.

  + Part 4. sometimes called
     + *encapsulation*;
     + an *abstraction barrier*;
     + *information hiding*.


   **Example**: A Stack ADT

```
      Time	Operation			Stack
      ---------------------------------------------------------
      0   	nothing             Empty
      1   	push(A)             A Empty       // LHS is top
      2   	push(C)             C A Empty
      3   	push(B)             B C A Empty
      4   	pop()               C A Empty  ==> returns B
```

In Java:

- *interfaces* are specifications of types
- *classes* provide implementations of the specifications.

A specification:

```java
public interface Stack {
  void push(T item);
  T pop();
  boolean isEmpty();
  int size();
}
```

An implementation:

```java
public class MyStack implements Stack {
... implementations of push, pop, isEmpty, size ...
}
```

#### CS1102 : a twisted pair of plot-lines:

+ fundamental data structures and their associated algorithms. E.g., Stacks, Queues, Priority Queues, Hash Tables, Trees, ...

  - Sequential or linked representations;
  - Structural and/or relational properties;
  - Mutable (ephemeral) or immutable (persistent) types.

+ how to develop ADTs and other modular code.

+ We use Java for CSCI 1102:
  - because it has types;
  - because it still (?) has roots in the software industry ...

+ we will use Java
  - *interfaces* as specifications of ADTs and
  - *classes* as implementations of ADTs.


---

## 2. Introduction to Java

+ installing Dr. Java

  + basic usage of Dr. Java --- the three panes

+ From Python or OCaml to Java

  + Resources:

    1. SW Section 1.1:

    http://algs4.cs.princeton.edu/11model/

    2. Java4Python.pdf

    http://www.cs.bc.edu/~muller/teaching/cs102/s14/dist/docs/Java4Python.pdf

+ As with virtually every programming language, the main organizing form in Java is the *function*

NB: In Java, the word *method* (or sometimes *procedure*) is often used in lieu of *function* we will use *function* even though its meaning is different than its use in mathematics

  + for the most part, Java programs consist of collections of functions,

+ OCaml is in the tradition of the programming language LISP:

  + one runs an OCaml program by *simplification* of some expression, OCaml simplifies the expression seeking its value,

  + OCaml is statically typed but no type annotations are required, what type checking there is occurs when the program is run, i.e., at run-time or dynamically.

+ Like Python, Java is in the tradition of the programming language C:

  + statement-oriented --- run the program by -execution- of some statements, the statement forms include expressions, but they are secondary,

  + explicit type annotations for variables and functions,

  + in order to execute a Java program, one feeds it to a java *compiler*, the compiler checks the source code to confirm that it is well-formed and to confirm that the all definitions are consistent with the provided type annotations.

    If everything checks out, the compiler translates the java source code to "class files" containing java *byte codes* in the language of java virtual machine (JVM):

    ```
    +------------+      +===========+      +-------------+
    |            |      |           |      |             |
    | Point.java | -->  |   javac   | -->  | Point.class |
    |            |      |           |      |             |
    +------------+      +===========+      +-------------+
    ```

    The resulting class file can subsequently be executed by the JVM:

    ```
    +-------------+      +==========+
    |             |      |          |
    | Point.class | -->  |   java   |
    |             |      |          |
    +-------------+      +==========+
    ```

    NB: 

     - the Java compiler is called `javac` and the JVM is called `java`.

     - it was probably a dumb idea to call the byte-code file a "class file", "jvm file" probably would have been a better choice.

+ Another important difference is that almost everything that is defined in Java, including functions, are housed within *classes*.

  So looking at the language source files, in Python we would have a file `gcd.py`:

      # file: gcd.py
      # author: Bob Muller
      #
      # Euclid's algorithm for computing the greatest common divisor of two positive integers.
      #
      def gcd(m, n):
        if n == 0:
          return m
        else:
        return gcd(n, m % n)

 While in Java we would have more elaborate packaging:

```java
1. // file: Gcd.java
2. // author: Bob Muller
3. // date: January 14, 2018
4. //
5. // Euclid's algorithm for computing the greatest common divisor of
6. // two positive integers.
7. //
8. public class Gcd {
9.   public static int gcd(int m, int n) {
10.    if (n == 0)
11.      return m;
12.    else
13.      return gcd(n, m % n);
14.   }
16.
15.  public static void main(String[] args) {
17.    int answer = gcd(30, 20);
18.
19.    System.out.format("gcd(30, 20) = %d\n", answer);
20.  }
21.}
```

**Notes**:

1. The filename `Gcd.java` starts with a capital letter (i.e., `G`) and that the name of the public class in the file must match the file name.

2. Java follows the tradition of the C in using the special name *main* as the name of the function that is the starting point for execution of the code.  When this program is compiled and fed to the JVM from the command-line (or Dr. Java Interactions window) as in:

   ```bash
   > java Gcd
   ```

   The JVM will look for a (static) function called `main` as the launch point. When this `main` function is executed, inputs can be provided to main through the formal parameter `args`. E.g., given the command line

   ```bash
   > java Gcd Mary Sue Alice
   ```

   `args[0]` would hold the String `"Mary"`, `args[1]` would hold the String `"Sue"` and `args[2]` would hold the String `"Alice"`. Note that in this case, the index 3 would be out of bounds for array `args` and a run-time error would arise.

3. Just to be clear:

   + the occurrences of the variables m and n in line 9 are called *formal parameters*. Formal parameters are *binding occurrences*or declarations of variables, in Java, these always include a type annotation, the occurrence of the variable answer in line 19 is also a binding occurrence, though it is a local variable rather than a formal parameter,

   + in line 13, the expression `gcd(n, m % n)` is a *call* or *use* of the `gcd` function, the two subexpressions `n` and `m % n` are *actual arguments*, i.e., input expressions for the function
     `gcd`,

   + for a function call to be well-formed, it must have the same number of actual arguments as the function definition and the type of each argument must be consistent with the type of the corresponding formal parameter.

4. Whereas functions are the principal organizing form in both Python and Java, in Java, the `class` is also central. To be clear, Java classes have two roles, a principal one and a secondary one:

   1. the principal role: classes serve as *implementations* of new, programmer defined types, e.g., in

      ```
      Point p = new PointC(.2, .3);
      ```

      the `PointC` class is an implementation of the `Point` type. The value of the expression `new PointC(.2, .3)` is sometimes called an *instance of* `PointC`. I will usually refer to it as a *value*.

   2. the secondary role: to *aggregate* related definitions.

 + Java Types

   Java has two kinds of types:

    1. base types
      + void
      + int (long, short, byte)
      + double (float)
      + boolean
      + char

      + NB: values of base type are -atomic-, intuitively, they are small

    2. reference types --- the values of `new` expressions:

      `new ClassName( … )`

      NOTES: 

       + the choice of the word "reference" will be clear momentarily,

       + When the class is implementing an ADT we also view the implemented interface as a type.

  + Memory/Storage: 

    Since we're concerned with how data is represented, we should know something about storage. In this course, we're primarily interested in ephemeral memory, aka Random Access Memory or RAM:

    RAM organized in two parts:

      + static RAM — where your code resides,

      + dynamic RAM — where your data resides
        + organized in two parts:

        + the *call stack* --- storage for function variables, this storage is allocated when a function is called and automatically de-allocated when the function exits,

        + the *heap* --- storage for values of reference type, i.e., for the (non-atomic) values of -new- expressions. E.g.,

          ```
          Point p = new PointC(.2, .3);
          ```

          Gives rise to:
          ```
                                     heap
           +---+                  +--------+
          p| o-+----------------->|  +----+|
           +---+                  | x| .2 ||
                                  |  +----+|
                                  | y| .3 ||
                                  |  +----+|
                                  | ...    |
                                  +--------+
          ```

  + Java Libraries:

    + in order of granularity, Java's aggregation (or abstraction) forms are:
      + functions 
      + classes
      + packages
      + modules

    + classes aggregate related functions
    + packages aggregate related classes

    + Java Standard Library:
      + includes a default package: `java.lang` whose classes are available "for free"
      + items in other Java library packages must be fully specified, e.g.,
        + `java.util.Queue`
        + or *imported*:
          - `import java.util.Queue;`   // retrieve just one class name, or
          - `import java.util.*;`          // everything in package

      + NB: java.lang has a *wrapper class* for each of the non-void base types:

            base type            wrapper class
            ----------------------------------
            int                  Integer
            double               Double
            char                 Character
            boolean              Boolean

        + The wrapper classes house various utility functions.

        + back-and-forth between the base type and the "wrapped" or "boxed" type:

          ```java
          Integer myInt = new Integer(12);    // boxing
          int i = myInt.intValue();           // unboxing
          ```

        + Since Java 1.5 (aka 5), the compiler will usually (always?) do the boxing/unboxing for you automatically. Thus, if an expression context requires an Integer but your code has an int, it will give you a free "new Integer(...)" and vice-versa. This is called *auto-boxing*.

    + SW: all classes made known to Dr. Java by installation!

