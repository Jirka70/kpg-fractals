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
  - `Alphabet`: L R + -
  - `Axiom`: L
  - `Rewriting rules`: L → L+R++R-L--LL-R+
    - R → -L+RR++R+L--L-R
  - `L R` - move and draw forward
  - `+` - turn left
  - `-` - turn right

<p align="center">
  <img width="555" alt="Bildschirmfoto 2024-04-17 um 2 33 39 PM" src="https://github.com/Jirka70/kpg-fractals/assets/120426468/a844ff3b-4b31-4179-82b1-54a3bfe983b7">
  <br>
  Colored Gosper curve
</p>

- **Islands and lakes**
  - `Alphabet`: F f + -
  - `Axiom`: F+F+F+F
  - `Rewriting rules`: F → F+f-FF+F+FF+Ff+FF-f+FF-F-FF-Ff-FFF
    - f → ffffff
  - `F` - move and draw forward
  - `f` - move forward
  - `+` - turn left
  - `-` - turn right

- **Koch flake**
  - similar to the fractal `Snowflake` defined below. Nevertheless, the l-system of these fractals is defined in another way
  - `Alphabet`: F + -
  - `Axiom`: F
  - `Rewriting rules`: F → F+F--F+F
  - `F` - move and draw forward
  - `+` - turn left
  - `-` - turn right


<p align="center">
  <img width="585" alt="Bildschirmfoto 2024-04-17 um 7 30 37 PM" src="https://github.com/Jirka70/kpg-fractals/assets/120426468/483aecb6-304d-4492-9daf-538b9bce6fb5">
  <br>
  Koch flake
</p>

- **Sierpinski arrowhead triangle**
  - immensely interesting fractal
  - `Alphabet`: A B + -
  - `Axiom`: A
  - `Rewriting rules`: A → B−A−B
    -  B → A+B+A
  -  `A, B` - draw and move forward
  -  `+` - turn left
  -  `-` - turn right

<p align="center">
  <img width="475" alt="Bildschirmfoto 2024-04-17 um 7 41 22 PM" src="https://github.com/Jirka70/kpg-fractals/assets/120426468/c6b03ece-586f-4f4b-acc5-1dc8094f144b">
  <br>
  Sierpinski arrowhead
</p>


- **Tree**
  - younger part of tree is in green color and the older part is colored to brown color
  - `Alphabet`: F + -
  - `Axiom`: F
  - `Rewriting rules`: F → F+F--F+F
  - `F` - move and draw forward
  - `+` - turn left
  - `-` - turn right
    
<p align="center">
  <img width="611" alt="Bildschirmfoto 2024-04-17 um 7 45 56 PM" src="https://github.com/Jirka70/kpg-fractals/assets/      120426468/7fe750e9-4ccf-409c-a112-d1b9399e222e">
  <br>
  Colored tree
</p>

- **Snowflake**
  - similar to `Koch flake`
  - `Alphabet`: F + -
  - `Axiom`: F → F-F++F-F
  - `F` - move and draw forward
  - `+` - turn left
  - `-` - turn right

<p align="center">
<img width="472" alt="Bildschirmfoto 2024-04-17 um 7 50 22 PM" src="https://github.com/Jirka70/kpg-fractals/assets/120426468/0404e9c6-bc29-4259-87c8-2fd25f1ccf7b">
  <br>
  Snowflake
</p>

