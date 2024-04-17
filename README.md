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
- Somehow, when the fractal is selected, the combobox wrongly selects the fractal. See figure below:
  <p align="center">
  <img width="178" alt="Bildschirmfoto 2024-04-17 um 10 23 12 AM" src="https://github.com/Jirka70/kpg-fractals/assets/120426468/ebdfcde8-6e7c-4637-8bea-b45a43c78ff3">
  <br>
  Application bug
</p>
- if this occures, please, just restart the application. I dont know how to fix that at now...

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

<p align="center">
  <img width="555" alt="Bildschirmfoto 2024-04-17 um 2 33 39 PM" src="https://github.com/Jirka70/kpg-fractals/assets/120426468/a844ff3b-4b31-4179-82b1-54a3bfe983b7">
  <br>
  Colored Gosper curve
</p>






