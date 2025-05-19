package pe.edu.upeu.appturismo202501.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upeu.appturismo202501.repository.CategoryRepositoryImp
import pe.edu.upeu.appturismo202501.repository.CategoryRespository
import pe.edu.upeu.appturismo202501.repository.LoginUserRepository
import pe.edu.upeu.appturismo202501.repository.LoginUserRespositoryImp
import pe.edu.upeu.appturismo202501.repository.RegisterRepository
import pe.edu.upeu.appturismo202501.repository.RegisterRepositoryImpl

import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun
            loginUserRepository(loginRepos:LoginUserRespositoryImp):LoginUserRepository
    @Binds
    @Singleton
    abstract fun
            registerRepository(registerRepos:RegisterRepositoryImpl):RegisterRepository
    @Binds
    @Singleton
    abstract fun
            categoryRepository(categoryRepos:CategoryRepositoryImp):CategoryRespository
}