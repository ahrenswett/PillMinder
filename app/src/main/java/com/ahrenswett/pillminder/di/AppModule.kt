package com.ahrenswett.pillminder.di

import android.app.Application
import androidx.room.Room
import com.ahrenswett.pillminder.data.PillMinderDatabase
import com.ahrenswett.pillminder.data.repositories.BottleRepoImpl
import com.ahrenswett.pillminder.data.repositories.CabinetRepoImpl
import com.ahrenswett.pillminder.data.repositories.ConsumableRepoImpl
import com.ahrenswett.pillminder.domain.repos.BottleRepo
import com.ahrenswett.pillminder.domain.repos.CabinetRepo
import com.ahrenswett.pillminder.domain.repos.ConsumableRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Create the Database
    @Provides
    @Singleton
    fun providePillMinderDatabase(app: Application): PillMinderDatabase{
        return Room.databaseBuilder(
            app,
            PillMinderDatabase::class.java,
            "pill_minder_database"
        ).build()
    }

    // Create the Repositories
    @Provides
    @Singleton
    fun provideCabinetRepository(db: PillMinderDatabase) : CabinetRepo{
        return( CabinetRepoImpl(db.cabinetDAO))
    }

    @Provides
    @Singleton
    fun provideBottleRepo(db: PillMinderDatabase) : BottleRepo{
        return( BottleRepoImpl(db.bottleDAO, db.cabinetDAO))
    }

    @Provides
    @Singleton
    fun provideConsumableRepo(db: PillMinderDatabase) : ConsumableRepo{
        return( ConsumableRepoImpl(db.consumableDAO))
    }
}