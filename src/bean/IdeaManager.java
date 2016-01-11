package bean;

import java.util.HashMap;
import java.util.Map;

public class IdeaManager {
	private Map<Long, Idea> ideas = new HashMap<Long, Idea>();
	private IdeaManager instance;
	public IdeaManager Instance() {
		return instance;
	}
}
