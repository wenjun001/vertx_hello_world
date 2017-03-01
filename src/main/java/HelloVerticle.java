
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class HelloVerticle  extends AbstractVerticle {
    @Override
    public void start(Future<Void> fut) {
        vertx
                .createHttpServer()
                .requestHandler(r -> {
                    r.response().end("<h1>Hello from my first " +
                            "Vert.x 3 hello world</h1>");
                })
                .listen( config().getInteger("http.port", 38081), result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail(result.cause());
                    }
                });
    }

}