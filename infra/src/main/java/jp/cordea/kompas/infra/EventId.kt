package jp.cordea.kompas.infra

inline class EventId(val value: Int) {
    companion object {
        val EMPTY = EventId(0)
    }
}
