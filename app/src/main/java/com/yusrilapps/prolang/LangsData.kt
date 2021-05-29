package com.yusrilapps.prolang

object LangsData {
    private val langNames = arrayOf(
        "HTML",
        "CSS",
        "Javascript",
        "PHP",
        "Python",
        "Java",
        "Kotlin",
        "GO",
        "C++",
        "C#",
    )

    private val langCreateds = intArrayOf(
        1993,
        1996,
        1995,
        1994,
        1991,
        1995,
        2010,
        2009,
        1985,
        2003,
    )

    private val langLogos = intArrayOf(
        R.drawable.html5,
        R.drawable.css3,
        R.drawable.js,
        R.drawable.php,
        R.drawable.python,
        R.drawable.java,
        R.drawable.kotlin,
        R.drawable.go,
        R.drawable.c_plusplus,
        R.drawable.c_sharp,
    )

    private val langDescriptions = arrayOf(
        "HTML (HyperText Markup Language) is the most basic building block of the Web. It defines the meaning and structure of web content. Other technologies besides HTML are generally used to describe a web page's appearance/presentation (CSS) or functionality/behavior (JavaScript).",
        "CSS (Cascading Style Sheets) allows you to create great-looking web pages, but how does it work under the hood? This article explains what CSS is, with a simple syntax example, and also covers some key terms about the language.",
        "JavaScript is a scripting or programming language that allows you to implement complex features on web pages — every time a web page does more than just sit there and display static information for you to look at — displaying timely content updates, interactive maps, animated 2D/3D graphics, scrolling video jukeboxes, etc. — you can bet that JavaScript is probably involved. It is the third layer of the layer cake of standard web technologies, two of which (HTML and CSS) we have covered in much more detail in other parts of the Learning Area.",
        "PHP (recursive acronym for PHP: Hypertext Preprocessor) is a widely-used open source general-purpose scripting language that is especially suited for web development and can be embedded into HTML",
        "Python is an interpreted, object-oriented, high-level programming language with dynamic semantics. Its high-level built in data structures, combined with dynamic typing and dynamic binding, make it very attractive for Rapid Application Development, as well as for use as a scripting or glue language to connect existing components together. Python's simple, easy to learn syntax emphasizes readability and therefore reduces the cost of program maintenance. Python supports modules and packages, which encourages program modularity and code reuse. The Python interpreter and the extensive standard library are available in source or binary form without charge for all major platforms, and can be freely distributed.",
        "Java is a programming language and computing platform first released by Sun Microsystems in 1995. There are lots of applications and websites that will not work unless you have Java installed, and more are created every day. Java is fast, secure, and reliable. From laptops to datacenters, game consoles to scientific supercomputers, cell phones to the Internet, Java is everywhere! ",
        "Kotlin is an open-source statically typed programming language that targets the JVM, Android, JavaScript and Native. It’s developed by JetBrains",
        "Go, or Golang, is an open source programming language. It’s statically typed and produces compiled machine code binaries. Developers say that Google's Go language is the C for the twenty-first century when it comes to syntax. However, this new programming language includes tooling that allows you to safely use memory, manage objects, collect garbage, and provide static (or strict) typing along with concurrency",
        "C++ is an object-oriented computer language created by notable computer scientist Bjorne Stroustrop as part of the evolution of the C family of languages. C++ is pronounced \"see-plus-plus.\" It was developed as a cross-platform improvement of C to provide developers with a higher degree of control over memory and system resources.",
        "C# (pronounced \"See Sharp\") is a modern, object-oriented, and type-safe programming language. C# enables developers to build many types of secure and robust applications that run in the .NET ecosystem. C# has its roots in the C family of languages and will be immediately familiar to C, C++, Java, and JavaScript programmers. This tour provides an overview of the major components of the language in C# 8 and earlier.",
    )

    private val langDocUrls = arrayOf(
        "https://developer.mozilla.org/en-US/docs/Web/HTML",
        "https://developer.mozilla.org/en-US/docs/Web/CSS",
        "https://www.javascript.com/",
        "https://www.php.net/",
        "https://www.python.org/",
        "https://www.java.com/en/",
        "https://kotlinlang.org/",
        "https://golang.org/",
        "https://isocpp.org/",
        "https://docs.microsoft.com/en-us/dotnet/csharp/",
    )

    private fun addLang(position: Int, list: ArrayList<Lang>) {
        val lang = Lang()
        lang.id = position
        lang.name = langNames[position]
        lang.created = langCreateds[position]
        lang.logo = langLogos[position]
        lang.description = langDescriptions[position]
        lang.docUrl = langDocUrls[position]
        lang.favorite = favoriteLists.contains(position)
        list.add(lang)
    }

    var favoriteLists = ArrayList<Int>()

    val listData: ArrayList<Lang>
        get() {
            val list = arrayListOf<Lang>()
            for (position in langNames.indices) {
                addLang(position, list)
            }
            return list
        }

    val favoriteListData: ArrayList<Lang>
        get() {
            val list = arrayListOf<Lang>()
            for (position in langNames.indices) {
                if (!favoriteLists.contains(position)) {
                    continue
                }
                addLang(position, list)
            }
            return list
        }
}