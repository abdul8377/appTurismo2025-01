package pe.edu.upeu.appturismo202501.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lpe/edu/upeu/appturismo202501/data/remote/RestRegister;", "", "register", "Lretrofit2/Response;", "Lpe/edu/upeu/appturismo202501/modelo/RegisterResp;", "userRegister", "Lpe/edu/upeu/appturismo202501/modelo/RegisterDto;", "(Lpe/edu/upeu/appturismo202501/modelo/RegisterDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface RestRegister {
    
    @retrofit2.http.POST(value = "register")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object register(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    pe.edu.upeu.appturismo202501.modelo.RegisterDto userRegister, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<pe.edu.upeu.appturismo202501.modelo.RegisterResp>> $completion);
}