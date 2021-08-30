<div id="top"></div>

<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/greydelta/bin-packing-problem">
    <img src="images/logo.png" alt="Logo">
  </a>

<h3 align="center">Bin Packing Problem</h3>

  <p align="center">
    A Java Program to solve the Bin Packing Problem with Next Fit & Best Fit Decreasing algorithm 
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

[![program visual representation][product-screenshot]](#)

This program aims to demonstrate the use of algorithms to solve the bin packing problem and choose the optimal solution.

The bin packing problem is defined by 2 properties, which are the item sizes and the bin container. In this case, a delivery processing facility is used to simulate a scenario.

* bin capacity = Truck load
* item size = Package weight

In each delivery batch, the algorithm would determine which **PACKAGE** should be loaded into which **TRUCK**.

The program will require the user to input:
* Truck capacity / load
* The weight of the packages

Or conversely, use data from the existing data files:
* Make changes accordingly in `Main.java`, under Method B2 - `getDataFromFile()`

The program will then generate the solutions based on the 2 algorithms:
* Next Fit Algorithm (_Feasible solution_)
* Best Fit Decreasing Algorithm (_Optimal solution_)

#### Assumptions:
1. Weight ----> Measured only in KG (only in Integer)
2. Num of Packages ----> Any number of packages is acceptable
3. Size --->
- Assume that company has estimated that the load limit for each truck has taken into account the size of parcel (regardless of how big or small)
- Hence, physical size is disregarded in the calculation of the two following approximation algorithms



<p align="right">(<a href="#top">back to top</a>)</p>

### Sample Output
[![program sample output 1][product-screenshot1]](#)

<p align="right">(<a href="#top">back to top</a>)</p>

### Built With

[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/en/) 

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started


### Prerequisites

* Recommended IDE: 

    [![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)](https://www.eclipse.org/ide/)



### Installation

1. Download & install [JRE-15](https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html) according to your OS

1. Import Project Folder in Eclipse IDE

1. Right click on Project Folder in Project Folder View

1. Click "Build Path"

1. Click "Configure Build Path"

1. Under the "Libraries" Tab, click JRE System Library

1. Click "Edit"

1. Under "Execution Environment", choose "JavaSE-15 (jre)" from the dropdown

1. Click "Finish" then "Apply and Close"

<!-- USAGE EXAMPLES -->
## Usage

1. Right click on Project Folder in Project Folder View

1. Click "Run As"

1. Click "Java Application"

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Your Name - [@greydelta1](https://twitter.com/greydelta1)

Project Link: [https://github.com/greydelta/bin-packing-problem](https://github.com/greydelta/bin-packing-problem)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* []()
* []()
* []()

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/greydelta/bin-packing-problem.svg?style=for-the-badge
[contributors-url]: https://github.com/greydelta/bin-packing-problem/graphs/contributors
[stars-shield]: https://img.shields.io/github/stars/greydelta/bin-packing-problem.svg?style=for-the-badge
[stars-url]: https://github.com/greydelta/bin-packing-problem/stargazers
[issues-shield]: https://img.shields.io/github/issues/greydelta/bin-packing-problem.svg?style=for-the-badge
[issues-url]: https://github.com/greydelta/bin-packing-problem/issues
[product-screenshot]: images/visual.png
[product-screenshot1]: images/output.png
