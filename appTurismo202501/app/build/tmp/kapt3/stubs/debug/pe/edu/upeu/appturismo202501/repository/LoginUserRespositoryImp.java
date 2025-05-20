package pe.edu.upeu.appturismo202501.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lpe/edu/upeu/appturismo202501/repository/LoginUserRespositoryImp;", "Lpe/edu/upeu/appturismo202501/repository/LoginUserRepository;", "restLoginUsuario", "Lpe/edu/upeu/appturismo202501/data/remote/RestLoginUsuario;", "(Lpe/edu/upeu/appturismo202501/data/remote/RestLoginUsuario;)V", "checkEmail", "Lretrofit2/Response;", "Lpe/edu/upeu/appturismo202501/modelo/CheckEmailResp;", "checkEmailDto", "Lpe/edu/upeu/appturismo202501/modelo/CheckEmailDto;", "(Lpe/edu/upeu/appturismo202501/modelo/CheckEmailDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginUsuario", "Lpe/edu/upeu/appturismo202501/modelo/LoginResp;", "userLogin", "Lpe/edu/upeu/appturismo202501/modelo/LoginDto;", "(Lpe/edu/upeu/appturismo202501/modelo/LoginDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendResetPasswordEmail", "Lpe/edu/upeu/appturismo202501/modelo/ApiResponse;", "request", "Lpe/edu/upeu/appturismo202501/modelo/ResetPasswordRequest;", "(Lpe/edu/upeu/appturismo202501/modelo/ResetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class LoginUserRespositoryImp implements pe.edu.upeu.appturismo202501.repository.LoginUserRepository {
    @org.jetbrains.annotations.NotNull()
    private final pe.edu.upeu.appturismo202501.data.remote.RestLoginUsuario restLoginUsuario = null;
    
    @javax.inject.Inject()
    public LoginUserRespositoryImp(@org.jetbrains.annotations.NotNull()
    pe.edu.upeu.appturismo202501.data.remote.RestLoginUsuario restLoginUsuario) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object loginUsuario(@org.jetbrains.annotations.NotNull()
    pe.edu.upeu.appturismo202501.modelo.LoginDto userLogin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<pe.edu.upeu.appturismo202501.modelo.LoginResp>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object checkEmail(@org.jetbrains.annotations.NotNull()
    pe.edu.upeu.appturismo202501.modelo.CheckEmailDto checkEmailDto, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<pe.edu.upeu.appturismo202501.modelo.CheckEmailResp>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object sendResetPasswordEmail(@org.jetbrains.annotations.NotNull()
    pe.edu.upeu.appturismo202501.modelo.ResetPasswordRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<pe.edu.upeu.appturismo202501.modelo.ApiResponse>> $completion) {
        return null;
    }
}