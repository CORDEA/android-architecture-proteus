package jp.cordea.kompas.model

inline class EventId(val value: Int) {
    companion object {
        val EMPTY = EventId(0)
    }
}
