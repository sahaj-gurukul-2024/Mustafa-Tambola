import org.example.Tambola
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TambolaTest {
    @Test
    fun `Top Row validation for acceptance claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("4, 16, 17, 63, 48, 76".split(", "))

        assertTrue(tambola.rowValidation(ticket, numberAnnounced, 0))
    }

    @Test
    fun `Top Row validation for rejection claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("4, 16, 17, 63, 48, 76, 12".split(", "))

        assertFalse(tambola.rowValidation(ticket, numberAnnounced, 0))
    }


    @Test
    fun `Bottom Row validation for acceptance claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("9, 16, 17, 56, 48, 83, 25, 64".split(", "))

        assertTrue(tambola.rowValidation(ticket, numberAnnounced, 2))
    }

    @Test
    fun `Bottom Row validation for rejection claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("9, 16, 17, 56, 48, 83, 25, 56, 43".split(", "))

        assertFalse(tambola.rowValidation(ticket, numberAnnounced, 2))
    }

    @Test
    fun `Early Five validation for acceptance claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("9, 54, 17, 64, 83, 12, 25, 52".split(", "))

        assertTrue(tambola.earlyNumberValidation(ticket, numberAnnounced, 5))
    }

    @Test
    fun `Early Five validation for rejection claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("9, 54, 17, 64, 83, 12, 25, 52, 67".split(", "))

        assertFalse(tambola.earlyNumberValidation(ticket, numberAnnounced, 5))
    }

    @Test
    fun `Middle Row validation for acceptance claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("7, 23, 52, 38, 80".split(", "))

        assertTrue(tambola.rowValidation(ticket, numberAnnounced, 1))
    }

    @Test
    fun `Middle Row validation for rejection claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("7, 23, 52, 38, 80, 12, 25, 67".split(", "))

        assertFalse(tambola.rowValidation(ticket, numberAnnounced, 1))
    }

    @Test
    fun `Full House validation for acceptance claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("4, 16, 63, 76, 80, 12, 25, 52, 48, 7, 23, 38, 9, 56, 64, 83".
        split(", "))

        assertTrue(tambola.earlyNumberValidation(ticket, numberAnnounced, 15))
    }

    @Test
    fun `Full House validation for rejection claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("4, 16, 63, 76, 80, 12, 25, 52, 48, 7, 23, 38, 80, 9, 56, 64, 83, 10".
        split(", "))

        assertFalse(tambola.earlyNumberValidation(ticket, numberAnnounced, 15))
    }
}