package pe.edu.upeu.appturismo202501.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u00a6@\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lpe/edu/upeu/appturismo202501/repository/LoginUserRepository;", "", "checkEmail", "Lretrofit2/Response;", "Lpe/edu/upeu/appturismo202501/modelo/CheckEmailResp;", "checkEmailDto", "Lpe/edu/upeu/appturismo202501/modelo/CheckEmailDto;", "(Lpe/edu/upeu/appturismo202501/modelo/CheckEmailDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginUsuario", "Lpe/edu/upeu/appturismo202501/modelo/LoginResp;", "userLogin", "Lpe/edu/upeu/appturismo202501/modelo/LoginDto;", "(Lpe/edu/upeu/appturismo202501/modelo/LoginDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendResetPasswordEmail", "Lpe/edu/upeu/appturismo202501/modelo/ApiResponse;", "request", "Lpe/edu/upeu/appturismo202501/modelo/ResetPasswordRequest;", "(Lpe/edu/upeu/appturismo202501/modelo/ResetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface LoginUserRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object loginUsuario(@org.jetbrains.annotations.NotNull()
    pe.edu.upeu.appturismo202501.modelo.LoginDto userLogin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<pe.edu.upeu.appturismo202501.modelo.LoginResp>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object checkEmail(@org.jetbrains.annotations.NotNull()
    pe.edu.upeu.appturismo202501.modelo.CheckEmailDto checkEmailDto, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<pe.edu.upeu.appturismo202501.modelo.CheckEmailResp>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendResetPasswordEmail(@org.jetbrains.annotations.NotNull()
    pe.edu.upeu.appturismo202501.modelo.ResetPasswordRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<pe.edu.upeu.appturismo202501.modelo.ApiResponse>> $completion);
}