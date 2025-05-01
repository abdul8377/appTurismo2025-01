package pe.edu.upeu.appturismo202501.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import pe.edu.upeu.appturismo202501.data.remote.RestLoginUsuario;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DataSourceModule_RestLoginUserFactory implements Factory<RestLoginUsuario> {
  private final DataSourceModule module;

  private final Provider<Retrofit> retrofitProvider;

  public DataSourceModule_RestLoginUserFactory(DataSourceModule module,
      Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public RestLoginUsuario get() {
    return restLoginUser(module, retrofitProvider.get());
  }

  public static DataSourceModule_RestLoginUserFactory create(DataSourceModule module,
      Provider<Retrofit> retrofitProvider) {
    return new DataSourceModule_RestLoginUserFactory(module, retrofitProvider);
  }

  public static RestLoginUsuario restLoginUser(DataSourceModule instance, Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(instance.restLoginUser(retrofit));
  }
}
