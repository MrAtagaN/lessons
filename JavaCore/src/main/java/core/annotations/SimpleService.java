package core.annotations;

@Service(name = "MySimpleService")
public class SimpleService {

    @Init
    public void lazyInit() throws Exception {
        System.out.println("lazyInit");
    }
}
