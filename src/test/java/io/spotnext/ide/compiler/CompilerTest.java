package io.spotnext.ide.compiler;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.spotnext.ide.compiler.util.MemoryStore;
import io.spotnext.ide.compiler.util.Store;

public class CompilerTest {

	@Test
	public void testCompiler() throws IOException {
		Store sourceStore = new MemoryStore();
		Store binaryStore = new MemoryStore();

		
		sourceStore.write("test/Test.java", IOUtils.toByteArray(CompilerTest.class.getResourceAsStream("/javasources/test/Test.java")));
		sourceStore.write("test/error/Error.java", IOUtils.toByteArray(CompilerTest.class.getResourceAsStream("/javasources/test/error/Error.java")));

		EclipseCompiler comp = new EclipseCompiler(sourceStore, binaryStore, ClassLoader.getPlatformClassLoader(), null);

		var results = new ArrayList<CompilationResult>();

		results.add(comp.compileAll());

		Assertions.assertTrue(results.get(0).getErrors().size() > 0);
	}
}
