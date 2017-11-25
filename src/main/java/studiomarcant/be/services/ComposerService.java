package studiomarcant.be.services;
import studiomarcant.be.model.Composer;

public interface ComposerService {
	
	public Object findAll();

	public Composer find(int id);

	public Composer find(String composerLastname);

	public Composer createComposer(Composer composer);

	public Composer updateComposer(Composer composer);

	public Composer deleteComposer(Composer composer);

}
