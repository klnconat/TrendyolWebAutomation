# TrendyolWebAutomation Installation Instructions

## Pre-conditions
1. install intelliJ
2. install Java 
3. install Git (https://git-scm.com/downloads)

## Instructions
1.	Create your folder
2.	Go to your folder
3.	CTRL+ Right Click
4.	Select "Git Bash here"
5.	git clone https://github.com/klnconatTrendyolWebAutomation.git
6.	Launch IntelliJ
7.	"Open or Import" OR "File > Open" 
8.	Browse to the root of cloned repository (Your Project Folder > InternProject)
9.	Wait for finish dependency resolve process
10.	Build > Build Project
11.	Wait for finish build process
12.	File > Project Structure
13.	Select Project SDK (use Java Version in preconditions #2)
14.	Apply > OK
15.	Build > Build Project
16.	Wait for finish build process
17.	Run > Edit Configurations > Templates > TestNG 
18.	Set VM options as "-ea -Dtestng.dtd.http=true"
19.	Apply > OK
20.	Right-Click on Trendyol/testng.xml
21.	Run "testng.xml"
