package pe.edu.upeu.appturismo202501.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lpe/edu/upeu/appturismo202501/repository/LoginUserRepository;", "", "loginUsuario", "Lretrofit2/Response;", "Lpe/edu/upeu/appturismo202501/modelo/LoginResp;", "userLogin", "Lpe/edu/upeu/appturismo202501/modelo/LoginDto;", "(Lpe/edu/upeu/appturismo202501/modelo/LoginDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface LoginUserRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object loginUsuario(@org.jetbrains.annotations.NotNull()
    pe.edu.upeu.appturismo202501.modelo.LoginDto userLogin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<pe.edu.upeu.appturismo202501.modelo.LoginResp>> $completion);
}