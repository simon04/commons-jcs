package org.apache.jcs.engine.control.group;

import java.io.Serializable;

import org.apache.jcs.engine.behavior.ICompositeCacheAttributes;
import org.apache.jcs.engine.behavior.IElementAttributes;
import org.apache.jcs.engine.control.CompositeCache;
import org.apache.jcs.engine.control.CompositeCacheManager;
import org.apache.jcs.auxiliary.AuxiliaryCache;

/** */
public class GroupCacheHub
    extends CompositeCacheManager
    implements Serializable
{
    /**
     * @see CompositeCacheManager#createInstance
     */
    protected static CompositeCacheManager createInstance()
    {
        return new GroupCacheHub();
    }

    /**
     * @see CompositeCacheManager#createSystemCache
     */
    protected CompositeCache createSystemCache( String cacheName,
                                       AuxiliaryCache[] auxCaches,
                                       ICompositeCacheAttributes cattr,
                                       IElementAttributes attr )
    {
        CompositeCache systemGroupIdCache =
            ( CompositeCache ) systemCaches.get( "groupIdCache" );

        return new GroupCache( cacheName, auxCaches, cattr, attr,
                               systemGroupIdCache );
    }

    /**
     * @see CompositeCacheManager#createCache
     */
    protected CompositeCache createCache( String cacheName,
                                 AuxiliaryCache[] auxCaches,
                                 ICompositeCacheAttributes cattr,
                                 IElementAttributes attr )
    {
        CompositeCache systemGroupIdCache =
            ( CompositeCache ) systemCaches.get( "groupIdCache" );

        return new GroupCache( cacheName, auxCaches, cattr, attr,
                               systemGroupIdCache );
    }
}
