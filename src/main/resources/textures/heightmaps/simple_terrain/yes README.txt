terrain.party README
====================

Hooray! You've exported some stuff from terrain.party v1.2!

If you should want to export this again for any reason:
  http://terrain.party/api/export?name=yes&tilePhysic=23.949464,61.576125,23.609758,61.414429

Now: what did you get?


Height Maps
-----------

  * yes Height Map (ASTER 30m).png

    ASTER is the most recent public survey of elevation on Earth. It has high
    coverage and high (~30m) resolution. However, the instrument can get
    confused by high concentraions of clouds and mountains, creating gaps in
    the data that need to be repaired by hand.
    http://asterweb.jpl.nasa.gov/gdem.asp


  * yes Height Map (Merged).png

[!] If you look at one height map, look at this one. [!]

    This is a mix of ASTER (~30m), USGS NED (~10m), and SRTM30+ (~900m). It
    provides good global elevation data (ASTER) and better US elevation data
    (USGS NED) with hole-filling and bathymetry from SRTM30+.


  * yes Height Map (SRTM30 Plus).png

    SRTM30+ data is very, very coarse (~900m). This might be useful if you'd
    like to follow the general contours of the land (and seafloor!) without
    having every single contour. (But really, it's here because... why not?)
    http://topex.ucsd.edu/WWW_html/srtm30_plus.html


Elevation Adjustment
--------------------

The original elevation models for this area contained elevations ranging from
1 through 287 meters.

These elevation values need to get transformed into a grayscale images. This
section describes how that translation was done in this particular case.

(The game isn't yet released, so what follows is a guess, but I think it's a
pretty good guess. If this turns out to be wrong, please use the link above to
re-export this data once we figure out what the deal is.)

Cities: Skylines supports terrain from 0m to 1024m. It represents elevations as
16-bit unsigned integers, which can be read directly from 16-bit height maps.
Each level therefore corresponds to 1/64th of a meter: 0 is 0m, 64 is 1m, etc.
Cities: Skylines maps default to having sea level at 40m, with typical terrain
starting at 60m.

These heightmaps were adjusted such that 1m (actual) is equal to 40m in
game. All other elevations are relative to that.

Again, the lowest point in these height maps is now 40m in game; all other
terrain is even higher. You will likely want to adjust the water level as a
result.


Missing Data
------------

The following height maps have some missing data:
  * ASTER 30m
  * Merged

Locations with missing data are represented by elevation of 0.

You'll probably want to smooth those areas out, fill them in from a different
height map, or reconstruct them from satellite imagery.


Enjoy!
http://terrain.party/
