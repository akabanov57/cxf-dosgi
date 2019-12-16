This is a clone of the original project [https://cxf.apache.org/distributed-osgi.html](https://cxf.apache.org/distributed-osgi.html)
# Project purpose.
Running examples in the original project uses [apache karaf](https://karaf.apache.org/) but sometimes we need to run services on [apache felix](https://felix.apache.org/).
## How to compile and run.
1. Download and install [openjdk 13](https://jdk.java.net/13/).
2. Download and install [Eclipse](https://www.eclipse.org/downloads/).
3. Install [bndtools](https://bndtools.org/installation.html) plugins into Eclipse.
4. Clone this project.
5. Create cxf-dosgi eclipse workspace.
6. Import into it [bndtools workspace](https://bndtools.org/concepts.html) from git.
7. Go to org.apache.cxf.dosgi.samples.xxx
8. Open rest-service-xxx.bndrun.
9. Click "resolve".
10. If there are no errors click "Run OSGi".
11. Read "readme.md".
