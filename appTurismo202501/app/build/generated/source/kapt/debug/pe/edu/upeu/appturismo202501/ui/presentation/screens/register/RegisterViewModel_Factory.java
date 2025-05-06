package pe.edu.upeu.appturismo202501.ui.presentation.screens.register;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import pe.edu.upeu.appturismo202501.repository.RegisterRepository;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class RegisterViewModel_Factory implements Factory<RegisterViewModel> {
  private final Provider<RegisterRepository> repositoryProvider;

  public RegisterViewModel_Factory(Provider<RegisterRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public RegisterViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static RegisterViewModel_Factory create(Provider<RegisterRepository> repositoryProvider) {
    return new RegisterViewModel_Factory(repositoryProvider);
  }

  public static RegisterViewModel newInstance(RegisterRepository repository) {
    return new RegisterViewModel(repository);
  }
}
