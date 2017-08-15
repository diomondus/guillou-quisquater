import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author n.melnikov
 * Creation date 03.05.2017
 */
public class FxApplication
        extends Application
{
  protected ConfigurableApplicationContext context;

  @Autowired
  private Scene mainScene;

  @Override
  public void start(Stage primaryStage)
          throws Exception
  {
    primaryStage.setTitle("Guillou-Quisquater Protocol");
    primaryStage.setScene(mainScene);
    primaryStage.show();
  }
}
