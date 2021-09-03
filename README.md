<div id="top"></div>

<!-- PROJECT SHIELDS -->

<div align="center">

[![Contributors][contributors-shield]][contributors-url] [![Forks][forks-shield]][forks-url] [![Stargazers][stars-shield]][stars-url] [![Issues][issues-shield]][issues-url] [![License][license-shield]][license-url]

</div>

<!-- PROJECT LOGO -->
<br />
<div align="center">
    <a href="https://github.com/greydelta/bin-packing-problem">
    <img src="images/logo.png" alt="Logo" width="533px" height="200px">
  </a>
<h3 align="center">Bin Packing Problem</h3>

  <p align="center">
     A CLI-based program to solve the Bin Packing Problem with Next Fit & Best Fit Decreasing algorithm 
    <br />
    <a href="https://github.com/greydelta/bin-packing-problem"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/greydelta/bin-packing-problem">View Demo</a>
    ·
    <a href="https://github.com/greydelta/bin-packing-problem/issues">Report Bug</a>
    ·
    <a href="https://github.com/greydelta/bin-packing-problem/issues">Request Feature</a>
  </p>
</div>

<!-- ABOUT THE PROJECT -->

## About The Project

This program aims to demonstrate the use of algorithms to solve the bin packing problem and choose the optimal solution.

The bin packing problem is defined by 2 properties, which are the item sizes and the bin container. In this case, a delivery processing facility is used to simulate a scenario.

- bin capacity = Truck load
- item size = Package weight

In each delivery batch, the algorithm would determine which **PACKAGE** should be loaded into which **TRUCK**.

The program will require the user to input:

- Truck capacity / load
- The weight of the packages

Or conversely, use data from the existing data files:

- Make changes accordingly in `Main.java`, under Method B2 - `getDataFromFile()`

The program will then generate the solutions based on the 2 algorithms:

- Next Fit Algorithm (_Feasible solution_)
- Best Fit Decreasing Algorithm (_Optimal solution_)

### Assumptions:

1. Weight ----> Measured only in KG (only in Integer)
2. Num of Packages ----> Any number of packages is acceptable
3. Size --->

- Assume that company has estimated that the load limit for each truck has taken into account the size of parcel (regardless of how big or small)
- Hence, physical size is disregarded in the calculation of the two following approximation algorithms

### Implementation Overview:

<div align="center">

[![screenshot][media-screenshot]](#)

</div>

### Flowcharts

<div align="center">
(Left: BFD Algorithm - Right: NF Algorithm):

<br />

[![flowchart][media-flowchart]](#)

</div>

<p align="right">(<a href="#top">back to top</a>)</p>

### Sample Output:

<div align="center">

[![screenshot1][media-screenshot1]](#)

</div>

<p align="right">(<a href="#top">back to top</a>)</p>

### Built With

[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/en/)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- GETTING STARTED -->

## Getting Started

## Using [![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)](https://www.eclipse.org/ide/) :

#### Prerequisites

- Install [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

#### Installation

- Import Project Folder in VS Code

#### Usage

1. Right click on `App.java`

1. Click "Run Java"

<p align="right">(<a href="#top">back to top</a>)</p>

## Using [![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)](https://www.eclipse.org/ide/) :

#### Prerequisites

- Download & install [JRE-15](https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html) and above according to your OS

#### Installation

1. Import Project Folder in Eclipse IDE

1. Right click on Project Folder in Project Folder View

1. Click "Build Path"

1. Click "Configure Build Path"

1. Under the "Libraries" Tab, click JRE System Library

1. Click "Edit"

1. Under "Execution Environment", choose "JavaSE-15 (jre)" from the dropdown

1. Click "Finish" then "Apply and Close"

### Usage

1. Right click on Project Folder in Project Folder View

1. Click "Run As"

1. Click "Java Application"

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement". Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- LICENSE -->

## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTACT -->

## Contact

<div align="center">
  <a href="https://twitter.com/greydelta1" target="_blank">
  <img src="https://img.shields.io/badge/twitter:  @greydelta1-%231DA1F2.svg?style=for-the-badge&logo=twitter&logoColor=white" alt=twitter style="margin-bottom: 5px;"/>
  </a> <a href="https://discord.com/users/379539771837513729" target="_blank">
  <img src="https://img.shields.io/badge/discord:  @double.decompose-%235865F2.svg?style=for-the-badge&logo=discord&logoColor=white" alt=discord style="margin-bottom: 5px;"/>
  </a> <a href="mailto:dev.aw.qwe@gmail.com" target="_blank">
  <img src="https://img.shields.io/badge/gmail:  dev.aw.qwe@gmail.com-D14836?style=for-the-badge&logo=gmail&logoColor=white" alt=mail style="margin-bottom: 5px;" />
  </a>
</div>

<br />

Project Link: [https://github.com/greydelta/bin-packing-problem](https://github.com/greydelta/bin-packing-problem)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->

## Acknowledgments

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->

[contributors-shield]: https://img.shields.io/github/contributors/greydelta/bin-packing-problem.svg?style=for-the-badge
[contributors-url]: https://github.com/greydelta/bin-packing-problem/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/greydelta/bin-packing-problem.svg?style=for-the-badge
[forks-url]: https://github.com/greydelta/bin-packing-problem/network/members
[stars-shield]: https://img.shields.io/github/stars/greydelta/bin-packing-problem.svg?style=for-the-badge
[stars-url]: https://github.com/greydelta/bin-packing-problem/stargazers
[issues-shield]: https://img.shields.io/github/issues/greydelta/bin-packing-problem.svg?style=for-the-badge
[issues-url]: https://github.com/greydelta/bin-packing-problem/issues
[license-shield]: https://img.shields.io/github/license/greydelta/bin-packing-problem.svg?style=for-the-badge
[license-url]: https://github.com/greydelta/bin-packing-problem/blob/master/LICENSE.txt
[media-screenshot]: images/visual.png
[media-screenshot1]: images/output.png
[media-flowchart]: images/flowchart.png
