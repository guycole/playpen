//
//  xc4test2AppDelegate.h
//  xc4test2
//
//  Created by Guy Cole on 10/26/11.
//  Copyright 2011 Digital Burro. All rights reserved.
//

#import <UIKit/UIKit.h>

@class MainViewController;

@interface xc4test2AppDelegate : NSObject <UIApplicationDelegate>

@property (nonatomic, retain) IBOutlet UIWindow *window;

@property (nonatomic, retain, readonly) NSManagedObjectContext *managedObjectContext;
@property (nonatomic, retain, readonly) NSManagedObjectModel *managedObjectModel;
@property (nonatomic, retain, readonly) NSPersistentStoreCoordinator *persistentStoreCoordinator;

- (void)saveContext;
- (NSURL *)applicationDocumentsDirectory;

@property (nonatomic, retain) IBOutlet MainViewController *mainViewController;

@end
