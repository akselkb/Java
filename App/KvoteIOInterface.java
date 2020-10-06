package app;

import java.io.IOException;

public interface KvoteIOInterface {

	void save(String filename, KvoteKalkulator calc) throws IOException;
	
	KvoteObjectLoader load(String filename) throws IOException;
	
	
}
