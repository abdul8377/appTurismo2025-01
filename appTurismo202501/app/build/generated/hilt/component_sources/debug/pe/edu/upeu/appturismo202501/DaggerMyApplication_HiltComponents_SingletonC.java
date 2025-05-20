package pe.edu.upeu.appturismo202501;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import pe.edu.upeu.appturismo202501.data.remote.RestCategory;
import pe.edu.upeu.appturismo202501.data.remote.RestLoginUsuario;
import pe.edu.upeu.appturismo202501.data.remote.RestRegister;
import pe.edu.upeu.appturismo202501.di.DataSourceModule;
import pe.edu.upeu.appturismo202501.di.DataSourceModule_ProvideBaseUrlFactory;
import pe.edu.upeu.appturismo202501.di.DataSourceModule_ProvideRetrofitFactory;
import pe.edu.upeu.appturismo202501.di.DataSourceModule_RestCategoryFactory;
import pe.edu.upeu.appturismo202501.di.DataSourceModule_RestLoginUserFactory;
import pe.edu.upeu.appturismo202501.di.DataSourceModule_RestRegisterFactory;
import pe.edu.upeu.appturismo202501.repository.CategoryRepositoryImp;
import pe.edu.upeu.appturismo202501.repository.CategoryRespository;
import pe.edu.upeu.appturismo202501.repository.LoginUserRepository;
import pe.edu.upeu.appturismo202501.repository.LoginUserRespositoryImp;
import pe.edu.upeu.appturismo202501.repository.RegisterRepository;
import pe.edu.upeu.appturismo202501.repository.RegisterRepositoryImpl;
import pe.edu.upeu.appturismo202501.ui.presentation.screens.LoginViewModel;
import pe.edu.upeu.appturismo202501.ui.presentation.screens.LoginViewModel_HiltModules;
import pe.edu.upeu.appturismo202501.ui.presentation.screens.forgotpassword.ForgotPasswordViewModel;
import pe.edu.upeu.appturismo202501.ui.presentation.screens.forgotpassword.ForgotPasswordViewModel_HiltModules;
import pe.edu.upeu.appturismo202501.ui.presentation.screens.register.RegisterViewModel;
import pe.edu.upeu.appturismo202501.ui.presentation.screens.register.RegisterViewModel_HiltModules;
import pe.edu.upeu.appturismo202501.ui.presentation.screens.welcome.viewModel.CategoryViewModel;
import pe.edu.upeu.appturismo202501.ui.presentation.screens.welcome.viewModel.CategoryViewModel_HiltModules;
import retrofit2.Retrofit;

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
public final class DaggerMyApplication_HiltComponents_SingletonC {
  private DaggerMyApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static MyApplication_HiltComponents.SingletonC create() {
    return new Builder().build();
  }

  public static final class Builder {
    private DataSourceModule dataSourceModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public Builder dataSourceModule(DataSourceModule dataSourceModule) {
      this.dataSourceModule = Preconditions.checkNotNull(dataSourceModule);
      return this;
    }

    public MyApplication_HiltComponents.SingletonC build() {
      if (dataSourceModule == null) {
        this.dataSourceModule = new DataSourceModule();
      }
      return new SingletonCImpl(dataSourceModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements MyApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements MyApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements MyApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements MyApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements MyApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements MyApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements MyApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends MyApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends MyApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends MyApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends MyApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(4).put(LazyClassKeyProvider.pe_edu_upeu_appturismo202501_ui_presentation_screens_welcome_viewModel_CategoryViewModel, CategoryViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.pe_edu_upeu_appturismo202501_ui_presentation_screens_forgotpassword_ForgotPasswordViewModel, ForgotPasswordViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.pe_edu_upeu_appturismo202501_ui_presentation_screens_LoginViewModel, LoginViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.pe_edu_upeu_appturismo202501_ui_presentation_screens_register_RegisterViewModel, RegisterViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
<<<<<<< HEAD
      static String pe_edu_upeu_appturismo202501_ui_presentation_screens_welcome_viewModel_CategoryViewModel = "pe.edu.upeu.appturismo202501.ui.presentation.screens.welcome.viewModel.CategoryViewModel";
=======
      static String pe_edu_upeu_appturismo202501_ui_presentation_screens_LoginViewModel = "pe.edu.upeu.appturismo202501.ui.presentation.screens.LoginViewModel";

      static String pe_edu_upeu_appturismo202501_ui_presentation_screens_forgotpassword_ForgotPasswordViewModel = "pe.edu.upeu.appturismo202501.ui.presentation.screens.forgotpassword.ForgotPasswordViewModel";
>>>>>>> a8d95cdf95ac07f291f28fbdc09b52390bee54a9

      static String pe_edu_upeu_appturismo202501_ui_presentation_screens_forgotpassword_ForgotPasswordViewModel = "pe.edu.upeu.appturismo202501.ui.presentation.screens.forgotpassword.ForgotPasswordViewModel";

      static String pe_edu_upeu_appturismo202501_ui_presentation_screens_welcome_viewModel_CategoryViewModel = "pe.edu.upeu.appturismo202501.ui.presentation.screens.welcome.viewModel.CategoryViewModel";

      @KeepFieldType
      LoginViewModel pe_edu_upeu_appturismo202501_ui_presentation_screens_LoginViewModel2;

      static String pe_edu_upeu_appturismo202501_ui_presentation_screens_register_RegisterViewModel = "pe.edu.upeu.appturismo202501.ui.presentation.screens.register.RegisterViewModel";

      @KeepFieldType
<<<<<<< HEAD
      CategoryViewModel pe_edu_upeu_appturismo202501_ui_presentation_screens_welcome_viewModel_CategoryViewModel2;

      @KeepFieldType
      ForgotPasswordViewModel pe_edu_upeu_appturismo202501_ui_presentation_screens_forgotpassword_ForgotPasswordViewModel2;

      @KeepFieldType
      LoginViewModel pe_edu_upeu_appturismo202501_ui_presentation_screens_LoginViewModel2;

      @KeepFieldType
      RegisterViewModel pe_edu_upeu_appturismo202501_ui_presentation_screens_register_RegisterViewModel2;
=======
      RegisterViewModel pe_edu_upeu_appturismo202501_ui_presentation_screens_register_RegisterViewModel2;

      @KeepFieldType
      CategoryViewModel pe_edu_upeu_appturismo202501_ui_presentation_screens_welcome_viewModel_CategoryViewModel2;
>>>>>>> a8d95cdf95ac07f291f28fbdc09b52390bee54a9
    }
  }

  private static final class ViewModelCImpl extends MyApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<CategoryViewModel> categoryViewModelProvider;

    private Provider<ForgotPasswordViewModel> forgotPasswordViewModelProvider;

    private Provider<LoginViewModel> loginViewModelProvider;

    private Provider<RegisterViewModel> registerViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.categoryViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.forgotPasswordViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.loginViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.registerViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(4).put(LazyClassKeyProvider.pe_edu_upeu_appturismo202501_ui_presentation_screens_welcome_viewModel_CategoryViewModel, ((Provider) categoryViewModelProvider)).put(LazyClassKeyProvider.pe_edu_upeu_appturismo202501_ui_presentation_screens_forgotpassword_ForgotPasswordViewModel, ((Provider) forgotPasswordViewModelProvider)).put(LazyClassKeyProvider.pe_edu_upeu_appturismo202501_ui_presentation_screens_LoginViewModel, ((Provider) loginViewModelProvider)).put(LazyClassKeyProvider.pe_edu_upeu_appturismo202501_ui_presentation_screens_register_RegisterViewModel, ((Provider) registerViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String pe_edu_upeu_appturismo202501_ui_presentation_screens_forgotpassword_ForgotPasswordViewModel = "pe.edu.upeu.appturismo202501.ui.presentation.screens.forgotpassword.ForgotPasswordViewModel";

      static String pe_edu_upeu_appturismo202501_ui_presentation_screens_register_RegisterViewModel = "pe.edu.upeu.appturismo202501.ui.presentation.screens.register.RegisterViewModel";

      static String pe_edu_upeu_appturismo202501_ui_presentation_screens_LoginViewModel = "pe.edu.upeu.appturismo202501.ui.presentation.screens.LoginViewModel";

      static String pe_edu_upeu_appturismo202501_ui_presentation_screens_welcome_viewModel_CategoryViewModel = "pe.edu.upeu.appturismo202501.ui.presentation.screens.welcome.viewModel.CategoryViewModel";

      @KeepFieldType
      ForgotPasswordViewModel pe_edu_upeu_appturismo202501_ui_presentation_screens_forgotpassword_ForgotPasswordViewModel2;

      @KeepFieldType
      RegisterViewModel pe_edu_upeu_appturismo202501_ui_presentation_screens_register_RegisterViewModel2;

      @KeepFieldType
      LoginViewModel pe_edu_upeu_appturismo202501_ui_presentation_screens_LoginViewModel2;

      @KeepFieldType
      CategoryViewModel pe_edu_upeu_appturismo202501_ui_presentation_screens_welcome_viewModel_CategoryViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // pe.edu.upeu.appturismo202501.ui.presentation.screens.welcome.viewModel.CategoryViewModel 
          return (T) new CategoryViewModel(singletonCImpl.bindCategoryRepositoryProvider.get());

          case 1: // pe.edu.upeu.appturismo202501.ui.presentation.screens.forgotpassword.ForgotPasswordViewModel 
          return (T) new ForgotPasswordViewModel(singletonCImpl.bindLoginUserRepositoryProvider.get());

          case 2: // pe.edu.upeu.appturismo202501.ui.presentation.screens.LoginViewModel 
          return (T) new LoginViewModel(singletonCImpl.bindLoginUserRepositoryProvider.get());

          case 3: // pe.edu.upeu.appturismo202501.ui.presentation.screens.register.RegisterViewModel 
          return (T) new RegisterViewModel(singletonCImpl.bindRegisterRepositoryProvider.get(), singletonCImpl.bindLoginUserRepositoryProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends MyApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends MyApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends MyApplication_HiltComponents.SingletonC {
    private final DataSourceModule dataSourceModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<String> provideBaseUrlProvider;

    private Provider<Retrofit> provideRetrofitProvider;

    private Provider<RestCategory> restCategoryProvider;

    private Provider<CategoryRepositoryImp> categoryRepositoryImpProvider;

    private Provider<CategoryRespository> bindCategoryRepositoryProvider;

    private Provider<RestLoginUsuario> restLoginUserProvider;

    private Provider<LoginUserRespositoryImp> loginUserRespositoryImpProvider;

    private Provider<LoginUserRepository> bindLoginUserRepositoryProvider;

    private Provider<RestRegister> restRegisterProvider;

    private Provider<RegisterRepositoryImpl> registerRepositoryImplProvider;

    private Provider<RegisterRepository> bindRegisterRepositoryProvider;

    private SingletonCImpl(DataSourceModule dataSourceModuleParam) {
      this.dataSourceModule = dataSourceModuleParam;
      initialize(dataSourceModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final DataSourceModule dataSourceModuleParam) {
      this.provideBaseUrlProvider = DoubleCheck.provider(new SwitchingProvider<String>(singletonCImpl, 3));
      this.provideRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 2));
      this.restCategoryProvider = DoubleCheck.provider(new SwitchingProvider<RestCategory>(singletonCImpl, 1));
      this.categoryRepositoryImpProvider = new SwitchingProvider<>(singletonCImpl, 0);
      this.bindCategoryRepositoryProvider = DoubleCheck.provider((Provider) categoryRepositoryImpProvider);
      this.restLoginUserProvider = DoubleCheck.provider(new SwitchingProvider<RestLoginUsuario>(singletonCImpl, 5));
      this.loginUserRespositoryImpProvider = new SwitchingProvider<>(singletonCImpl, 4);
      this.bindLoginUserRepositoryProvider = DoubleCheck.provider((Provider) loginUserRespositoryImpProvider);
      this.restRegisterProvider = DoubleCheck.provider(new SwitchingProvider<RestRegister>(singletonCImpl, 7));
      this.registerRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 6);
      this.bindRegisterRepositoryProvider = DoubleCheck.provider((Provider) registerRepositoryImplProvider);
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    @Override
    public void injectMyApplication(MyApplication myApplication) {
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // pe.edu.upeu.appturismo202501.repository.CategoryRepositoryImp 
          return (T) new CategoryRepositoryImp(singletonCImpl.restCategoryProvider.get());

          case 1: // pe.edu.upeu.appturismo202501.data.remote.RestCategory 
          return (T) DataSourceModule_RestCategoryFactory.restCategory(singletonCImpl.dataSourceModule, singletonCImpl.provideRetrofitProvider.get());

          case 2: // retrofit2.Retrofit 
          return (T) DataSourceModule_ProvideRetrofitFactory.provideRetrofit(singletonCImpl.dataSourceModule, singletonCImpl.provideBaseUrlProvider.get());

          case 3: // @javax.inject.Named("BaseUrl") java.lang.String 
          return (T) DataSourceModule_ProvideBaseUrlFactory.provideBaseUrl(singletonCImpl.dataSourceModule);

          case 4: // pe.edu.upeu.appturismo202501.repository.LoginUserRespositoryImp 
          return (T) new LoginUserRespositoryImp(singletonCImpl.restLoginUserProvider.get());

          case 5: // pe.edu.upeu.appturismo202501.data.remote.RestLoginUsuario 
          return (T) DataSourceModule_RestLoginUserFactory.restLoginUser(singletonCImpl.dataSourceModule, singletonCImpl.provideRetrofitProvider.get());

          case 6: // pe.edu.upeu.appturismo202501.repository.RegisterRepositoryImpl 
          return (T) new RegisterRepositoryImpl(singletonCImpl.restRegisterProvider.get());

          case 7: // pe.edu.upeu.appturismo202501.data.remote.RestRegister 
          return (T) DataSourceModule_RestRegisterFactory.restRegister(singletonCImpl.dataSourceModule, singletonCImpl.provideRetrofitProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
