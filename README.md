# CCNES Scorer

## What is CCNES?

CCNES stands for **Coping with Children's Negative Emotions Scale** -
it's a psychological test.

Beyond that, I'm not the best person to ask about what it measures and
how to interpret the results, and any information contained within
certainly shouldn't be taken as medical/legal advice etc!

## So - why?

My girlfriend is currently (July 2013) writing up her Psychology
master's dissertation investigating 'emotional competence' in children
with Autistic Spectrum Disorder (ASD). As part of her investigation,
she has been comparing results of this test between parents with ASD
children and parents with typically developing (TD) children.

In line with https://plus.google.com/+BrunoOliveira/posts/MGxauXypb1Y,
I thought I'd try to save her some time and automate the scoring
process!

If you've got any questions about the test itself, get hold of me via
Twitter (@jarohen) and I'll forward them on.

## Feedback/comments/etc

Yes please! This is intended to be an example ClojureScript
application that's larger than your average 'hello world' application. 

I'd especially appreciate comments on style/architecture/idioms etc. I
haven't found many particularly sizeable CLJS applications to analyse
and learn from so any 'patterns' here are only patterns that I've
derived through a couple of projects at home and work.

There's not a lot of server-side Clojure here - only enough to handle
requests and serve the compiled CLJS file.

## Running CCNES Scorer:

Development:

    lein cljsbuild auto & lein start
	
Deploying:

    # Clone git repo on deployment machine, then SSH and:

    lein cljsbuild once prod && lein start

I've currently got this deployed at [http://ccnes.pcr.me.uk].

## Licence

Code: &copy; James Henderson 2013, all rights reserved. Feel free to
get hold of me if you want to re-use this though!

CCNES: Fabes, R.A., Eisenberg, N., & Bernzweig, J. (1990). The Coping
with Children's Negative Emotions Scale: Procedures and
scoring. Available from authors. Arizona State
University. [http://www.public.asu.edu/~rafabes/cnesall.pdf]
