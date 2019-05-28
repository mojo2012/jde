package io.spotnext.ide.compiler;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * Utilities for transforming class and other names.
 * 
 * @author Group2
 * @version 5 November 2013
 */
public class NameUtils {

	private NameUtils() {
	}

	public static String toSourceName(String className) {
		return dotsToSlashes(className) + ".java";
	}

	public static String toBinaryName(String className) {
		return dotsToSlashes(className) + ".class";
	}

	public static String toClassName(String resourceName) {
		return slashesToDots(resourceName.substring(0, resourceName.lastIndexOf(".")));
	}

	public static String toInternalName(String className) {
		return dotsToSlashes(className);
	}

	public static String slashesToDots(String resourceName) {
		return resourceName.replace('/', '.').replace('\\', '.');
	}

	public static String dotsToSlashes(String resourceName) {
		return resourceName.replace('.', '/');
	}

	public static Collection<String> toClassNames(Collection<String> resourceNames) {
		return resourceNames.stream().map(r -> {
			return toClassName(r);
		}).collect(Collectors.toList());
	}

	public static String getClassName(char[][] compoundName) {
		return join(compoundName).toString();
	}

	public static String getClassName(char[] typeName, char[][] packageName) {
		return joinPrefix(packageName).append(typeName).toString();
	}

	public static String getPackageName(char[][] parentPackageName, char[] packageName) {
		return joinPrefix(parentPackageName).append(packageName).toString();
	}

	public static char[][] getCompoundName(String className) {
		return toCharArrays(Arrays.asList(StringUtils.split(className, ".")));
	}

	protected static char[][] toCharArrays(List<String> strings) {
		char[][] charArrays = new char[strings.size()][];
		for (ListIterator<String> it = strings.listIterator(); it.hasNext();) {
			int index = it.nextIndex();
			charArrays[index] = it.next().toCharArray();
		}
		return charArrays;
	}

	protected static StringBuilder join(char[][] parts) {
		StringBuilder joined = new StringBuilder();
		if (parts != null) {
			for (int i = 0; i < parts.length; i++) {
				if (i != 0) joined.append('.');
				joined.append(parts[i]);
			}
		}
		return joined;
	}

	protected static StringBuilder joinPrefix(char[][] parts) {
		StringBuilder joined = new StringBuilder();
		if (parts != null) {
			for (int i = 0; i < parts.length; i++) {
				joined.append(parts[i]);
				joined.append('.');
			}
		}
		return joined;
	}

}