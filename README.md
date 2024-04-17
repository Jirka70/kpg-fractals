# Fractals

# Task
- create fractal curves (each one 0.5 pt.)
- separate each iteration with color (i.e. make fluent color transition)

# Launch 
This is a JavaFX project. Just pull this repo to your favorite IDE with Java. All maven dependencies will be loaded automatically. At last, run the `Main` class.

# Application
- Application is able to show 6 different fractals. `Gosper curve`, `Islands and lakes`, `Koch curve`, `Sierpinski arrowhead triangle`, `Tree` and at last `Snowflake`.
- all fractals could change their color. If `Color fractal` checkbox is selected, fractal will be colored after the `Apply` button click.
- in the box, just select which curve you want to draw on the left side. The selected fractal will be drawn on the left, after the `Apply` button is clicked.
- there is bug, which 

# Each Fractals
- fractals are made with L-systems. IMO, its the best way to implement fractals.
- L-systems basically works as d0l gramatics.
- **Gosper curve**
  - `Alphabet`: L R + i
  - `axiom`: L
  - `Rewriting rules`: L -> L+R++R-L--LL-R+
    - R -> -L+RR++R+L--L-R
  - `L R` - move and draw forward
  - `+` - turn left
  - `-` - turn right
  -  




