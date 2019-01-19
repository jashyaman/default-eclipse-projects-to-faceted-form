package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * reference
 * https://stackoverflow.com/questions/2607289/converting-array-to-list-in-java
 * https://www.mkyong.com/java/how-to-traverse-a-directory-structure-in-java/
 * 
 */

public class Test {

	private static final String dir = ".settings";
	private static final String testdir = "C:\\Users\\shyraman\\workspace\\mvdls\\";


	public static void main(String[] args) {
		
		try  {
			File location = new File(testdir);
			System.out.println("start");
			    
				List<String> reqdDir = callSubDir(location, null);  
				
				if(reqdDir.size() != 0) {
					System.out.println("good");
				} else {
					System.out.println("check");
				}
				
				String fileName = "org.eclipse.wst.common.project.facet.core.xml";

				String contents = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
						"<faceted-project>\r\n" + 
						"  <installed facet=\"java\" version=\"1.8\"/>\r\n" + 
						"</faceted-project>\r\n" + 
						"";
				
				String fileName2 = "org.eclipse.jdt.core.prefs";
				String contents2 = "eclipse.preferences.version=1\r\n" + 
						"org.eclipse.jdt.core.compiler.codegen.inlineJsrBytecode=enabled\r\n" + 
						"org.eclipse.jdt.core.compiler.codegen.targetPlatform=1.8\r\n" + 
						"org.eclipse.jdt.core.compiler.compliance=1.8\r\n" + 
						"org.eclipse.jdt.core.compiler.problem.assertIdentifier=error\r\n" + 
						"org.eclipse.jdt.core.compiler.problem.enumIdentifier=error\r\n" + 
						"org.eclipse.jdt.core.compiler.source=1.8\r\n" + 
						"";
				
				String fileName3 = ".project";
				String contents3 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
						"<projectDescription>\r\n" + 
						"	<name>INSERT_NAME_HERE</name>\r\n" + 
						"	<comment></comment>\r\n" + 
						"	<projects>\r\n" + 
						"	</projects>\r\n" + 
						"	<buildSpec>\r\n" + 
						"		<buildCommand>\r\n" + 
						"			<name>org.eclipse.jdt.core.javabuilder</name>\r\n" + 
						"			<arguments>\r\n" + 
						"			</arguments>\r\n" + 
						"		</buildCommand>\r\n" + 
						"		<buildCommand>\r\n" + 
						"			<name>org.eclipse.wst.common.project.facet.core.builder</name>\r\n" + 
						"			<arguments>\r\n" + 
						"			</arguments>\r\n" + 
						"		</buildCommand>\r\n" + 
						"		<buildCommand>\r\n" + 
						"			<name>org.eclipse.m2e.core.maven2Builder</name>\r\n" + 
						"			<arguments>\r\n" + 
						"			</arguments>\r\n" + 
						"		</buildCommand>\r\n" + 
						"	</buildSpec>\r\n" + 
						"	<natures>\r\n" + 
						"		<nature>org.eclipse.m2e.core.maven2Nature</nature>\r\n" + 
						"		<nature>org.eclipse.wst.common.project.facet.core.nature</nature>\r\n" + 
						"		<nature>org.eclipse.jdt.core.javanature</nature>\r\n" + 
						"	</natures>\r\n" + 
						"</projectDescription>\r\n" + 
						"";
				
				String filename4 = ".classpath";
				String contents4 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
						"<classpath>\r\n" + 
						"	<classpathentry kind=\"src\" path=\"src/main/java\"/>\r\n" + 
						"	<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8\">\r\n" + 
						"		<attributes>\r\n" + 
						"			<attribute name=\"owner.project.facets\" value=\"java\"/>\r\n" + 
						"		</attributes>\r\n" + 
						"	</classpathentry>\r\n" + 
						"	<classpathentry kind=\"output\" path=\"bin\"/>\r\n" + 
						"</classpath>\r\n" + 
						"";
				
				for(String s : reqdDir) {
					
					File f = new File(s);
					if(f.isDirectory()) {
						String newcontents3 = contents3.replaceAll("INSERT_NAME_HERE", f.getParentFile().getName());
						File eclipseProjectConfigFile = new File(f.getParentFile().getAbsolutePath()+"\\"+fileName3);
						File eclipseCorePrefs = new File(f.getAbsolutePath()+"\\"+fileName2);
						File eclipseFacetFile = new File(f.getAbsolutePath()+"\\"+fileName);
						
						File projectClasspathFile = new File(f.getParentFile().getAbsolutePath()+"\\"+filename4);
						
						if(projectClasspathFile.exists() && !projectClasspathFile.isDirectory()) {
							//projectClasspathFile.delete();
							//Files.write(Paths.get(f.getParentFile().getAbsolutePath()+"\\"+filename4), contents4.getBytes());
						} else {
							Files.write(Paths.get(f.getParentFile().getAbsolutePath()+"\\"+filename4), contents4.getBytes());
						}
						
						if(eclipseCorePrefs.exists() && !eclipseCorePrefs.isDirectory()) {
							//eclipseCorePrefs.delete();
							//Files.write(Paths.get(f.getAbsolutePath()+"\\"+fileName2), contents2.getBytes());
						} else {
							Files.write(Paths.get(f.getAbsolutePath()+"\\"+fileName2), contents2.getBytes());
						}
						
						if(eclipseFacetFile.exists() && !eclipseFacetFile.isDirectory()) {
							//eclipseFacetFile.delete();
							//Files.write(Paths.get(f.getAbsolutePath()+"\\"+fileName), contents.getBytes());
						} else {
							Files.write(Paths.get(f.getAbsolutePath()+"\\"+fileName), contents.getBytes());
						}
						
						if(eclipseProjectConfigFile.exists() && !eclipseProjectConfigFile.isDirectory()) { 
						   // eclipseProjectConfigFile.delete();
						    //Files.write(Paths.get(f.getParentFile().getAbsolutePath()+"\\"+fileName3), newcontents3.getBytes());
						} else {
							Files.write(Paths.get(f.getParentFile().getAbsolutePath()+"\\"+fileName3), newcontents3.getBytes());
						}
						
						
					}
				}
			
		} catch(NullPointerException e) {
			System.err.println("error : location is null " + e.getMessage());
		} catch (IOException e) {
			System.err.println("error : Issue with writing to file " + e.getMessage());
		} 
		
		System.out.println("end");
	}

	private static List<String> callSubDir(File location,List<String> arr) {
		if(arr == null) {
			arr = new ArrayList<String>();
		}
		if(location.isFile()) {
			return arr;
		}
		if(location.isDirectory()) {
			if(location.getName().equalsIgnoreCase(dir)) {
				arr.add(location.getAbsolutePath());
			} else {
				for(String f : Arrays.asList(location.list())) {
					File file = new File(location.getAbsolutePath()+"\\"+f);;
					arr = callSubDir(file, arr);
				}
			}
		} else {
			return arr;
		}
		return arr;
	}
}
