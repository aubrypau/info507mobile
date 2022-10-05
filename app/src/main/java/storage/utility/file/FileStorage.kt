package storage.utility.file

import android.content.Context
import storage.utility.Storage
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.InputStreamReader
import java.io.OutputStreamWriter




abstract class FileStorage<T>(private val context: Context, name: String, extension: String): Storage<T>() {

    private val fileName = "storage_$name.$extension"
    private var data = HashMap<Int, T>()
    private var nextId = 1

    protected abstract fun create(id: Int, obj:T): T
    protected abstract fun dataToString(data: HashMap<Int, T>): String
    protected abstract fun stringToData(value :String): HashMap<Int,T>


    private fun read(){
        try{
            val input = context.openFileInput(fileName)
            //println(context.filesDir)
            if(input != null){
                val builder = StringBuilder()
                val bufferedReader = BufferedReader(InputStreamReader(input))
                var temp = bufferedReader.readLine()
                while(temp != null){
                    builder.append(temp)
                    temp = bufferedReader.readLine()
                }
                input.close()
                data = stringToData(builder.toString())
                nextId = if(data.keys.size == 0) 1 else data.keys.max() + 1
            }
        }catch(e: FileNotFoundException){
            write()
        }
    }

    private fun write(){
        val output = context.openFileOutput(fileName, Context.MODE_PRIVATE)
        val writer = OutputStreamWriter(output)
        writer.write(dataToString(data))
        writer.close()
    }

    override fun insert(obj: T): Int {
        data.put(nextId, create(nextId, obj))
        nextId ++
        write()
        return nextId -1
    }

    override fun delete(id: Int) {
        data.remove(id)
        write()
    }

    override fun find(id: Int): T? {
        return data[id]
    }

    override fun findAll(): List<T> {
        TODO("Not yet implemented")
    }

    override fun size(): Int {
        return data.size
    }

    override fun update(id: Int, obj: T) {
        TODO("Not yet implemented")
    }

}