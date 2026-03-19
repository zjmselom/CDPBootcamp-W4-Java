# CDPBootcamp-W4-Java

The following prompts were used in Copilot:

- Can you make this Video class an abstract class with the following fields: title, genre, and available (private, with getters/setters). Include one abstract method play() and two methods: rentVideo() that is unavailable and returnVideo, which is available

- Create Movie class, which is a subclass of Video. Make it implement play() with a custom message and include an overloaded method: play(String quality)(HD, 4K, etc)

- Build Movie - subclass of Video. It should implement play() differently (e.g print "Playing episode of series)

- Build Series - subclass of Video. It should implement play() differently (e.g print "Playing episode of series)

-Build this main class which creates an array of Video objects (mix of Movie and Series). It should demonstrate adding videos to the arrays, looping through and calling play() on each (show polymorphism), renting and returning a video (show encapsulation) , using the overloaded play() method, and print a lift of available videos using an array traversal