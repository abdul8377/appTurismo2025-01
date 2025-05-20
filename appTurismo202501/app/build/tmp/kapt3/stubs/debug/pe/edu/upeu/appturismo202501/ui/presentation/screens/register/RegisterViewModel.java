package pe.edu.upeu.appturismo202501.ui.presentation.screens.register;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020*J\u000e\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\tJ\u000e\u0010.\u001a\u00020*2\u0006\u0010-\u001a\u00020\tJ\u000e\u0010/\u001a\u00020*2\u0006\u0010-\u001a\u00020\tJ\u000e\u00100\u001a\u00020*2\u0006\u0010-\u001a\u00020\tJ\u000e\u00101\u001a\u00020*2\u0006\u0010-\u001a\u00020\tJ\u0006\u00102\u001a\u00020*R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0017R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u00158F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0017R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u00158F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0017R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u00158F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u00158F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0017R\u0019\u0010\'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00158F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u0017\u00a8\u00063"}, d2 = {"Lpe/edu/upeu/appturismo202501/ui/presentation/screens/register/RegisterViewModel;", "Landroidx/lifecycle/ViewModel;", "registerRepo", "Lpe/edu/upeu/appturismo202501/repository/RegisterRepository;", "loginRepo", "Lpe/edu/upeu/appturismo202501/repository/LoginUserRepository;", "(Lpe/edu/upeu/appturismo202501/repository/RegisterRepository;Lpe/edu/upeu/appturismo202501/repository/LoginUserRepository;)V", "_email", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_errorMessage", "_isLoading", "", "_lastName", "_loginSuccess", "_name", "_password", "_passwordConfirm", "_registerSuccess", "_userRole", "email", "Lkotlinx/coroutines/flow/StateFlow;", "getEmail", "()Lkotlinx/coroutines/flow/StateFlow;", "errorMessage", "getErrorMessage", "isLoading", "lastName", "getLastName", "loginSuccess", "getLoginSuccess", "name", "getName", "password", "getPassword", "passwordConfirm", "getPasswordConfirm", "registerSuccess", "getRegisterSuccess", "userRole", "getUserRole", "clearErrorMessage", "", "clearLoginSuccess", "onEmailChange", "value", "onLastNameChange", "onNameChange", "onPasswordChange", "onPasswordConfirmChange", "registerUser", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RegisterViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final pe.edu.upeu.appturismo202501.repository.RegisterRepository registerRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final pe.edu.upeu.appturismo202501.repository.LoginUserRepository loginRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _name = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _lastName = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _email = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _password = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _passwordConfirm = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _registerSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _loginSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _userRole = null;
    
    @javax.inject.Inject()
    public RegisterViewModel(@org.jetbrains.annotations.NotNull()
    pe.edu.upeu.appturismo202501.repository.RegisterRepository registerRepo, @org.jetbrains.annotations.NotNull()
    pe.edu.upeu.appturismo202501.repository.LoginUserRepository loginRepo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getLastName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getPasswordConfirm() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getRegisterSuccess() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getLoginSuccess() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getUserRole() {
        return null;
    }
    
    public final void onNameChange(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void onLastNameChange(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void onEmailChange(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void onPasswordChange(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void onPasswordConfirmChange(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void clearErrorMessage() {
    }
    
    public final void clearLoginSuccess() {
    }
    
    public final void registerUser() {
    }
}