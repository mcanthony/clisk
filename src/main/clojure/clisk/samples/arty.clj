(ns clisk.samples.arty
  (:use [clisk live]))

(defn demo []
  ;; 1: patterned grey noise with rainbow patches
  (show (offset (v* 0.1 (scale 0.03 vsnoise)) (rgb-from-hsl (v+ [0 0 0.5] (scale 0.3 vsnoise)))) :size 512)
  
  ;; 2: Christmas Spots
  (show (seamless 0.5 (v* [1 0.8 0 0] (compose vnoise [spots y z t]))) :size 512)
  
  ;; 3. String Theory
  (show (seamless 0.2 (v* 10 (scale 3 vnoise) (v- 0.1 (vmax 0 (vabs (v- plasma 0.5)))))) :size 512)
  
  ;; 4. Pastels
  (show (seamless 1.0 (offset (v* 4 vplasma) (v+ (offset 10 vnoise) 0.3))) :size 512)
  
  
  (show (let [voronoi1 (voronoi :points 100)] 
    (v* 20.0 (voronoi-blocks :voronoi voronoi1)))
    :size 256)  
  
  (show (vmax 0 (v+ -1.3 (scale 0.1 (v+ (vsin x) (vcos y))))))
  
  (show (rgb-from-hsl vsplasma))
  
  ;; islands
  (show (scale 0.25 (desert-map plasma)))
  )