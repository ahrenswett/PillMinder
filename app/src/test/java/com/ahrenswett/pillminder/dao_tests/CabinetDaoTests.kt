package com.ahrenswett.pillminder.dao_tests


//@RunWith(AndroidJUnit4::class)
//class CabinetDaoTests {
//
//    private lateinit var consumableDAO: ConsumableDAO
//    private lateinit var db: AppDatabase
//
//    @Before
//    fun createDb(){
//        val context: Context = ApplicationProvider.getApplicationContext()
//        db = Room.inMemoryDatabaseBuilder(context,AppDatabase::class.java)
//            .allowMainThreadQueries()
//            .build()
//        cabinetDao = db.cabinetDAO()
//    }
//
//    @After
//    @Throws(IOException::class)
//    fun closeDb(){
//        db.close()
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun addNewCabinetTest() : Unit = runBlocking {
//        val testName = "Broken Cabinet"
//        cabinetDao.addNewCabinet(Cabinet(testName))
//        val allCabinets = cabinetDao.listCabinets().first()
//        assertEquals(allCabinets.name, testName)
//    }
//
//}