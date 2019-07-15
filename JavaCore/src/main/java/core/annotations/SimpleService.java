package core.annotations;

@Service(name = "MySimpleService")
public class SimpleService {

    @Init(suppressException = true)
    public void lazyInit() throws Exception {
        System.out.println("lazyInit");
    }
}
